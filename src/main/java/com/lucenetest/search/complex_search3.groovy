package com.lucenetest.search

import org.apache.lucene.queryParser.QueryParser
import com.lucenetest.HibernateUtil
import org.hibernate.search.Search
import org.apache.lucene.util.Version
import org.apache.lucene.analysis.standard.StandardAnalyzer
import com.lucenetest.Student
import com.lucenetest.Education
import com.lucenetest.Publication
import com.lucenetest.Medical

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/22/11
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */

//Objective: Search for all students who have a "MAG" publication between 2006 - 2008, and have a medical "PF" degree from john hopkins
//Result: This should give 1 match
def fts = Search.getFullTextSession(HibernateUtil.getSession())

fts.beginTransaction()
String qry1 = "+publicationDate:[20060101 TO 20081231] +type:mag"
String qry2 = "+m_degreeCode:pf +m_institution:john*"

def parser = new QueryParser(Version.LUCENE_30, "firstName", new StandardAnalyzer(Version.LUCENE_30))

def luceneQuery = parser.parse(qry1)

def list = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()
list.each { println it }
def ids = list.collect { it.student.id }

luceneQuery = parser.parse(qry2)

def list2 = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()

def ids2 = list2.collect { it.student.id }


/*
luceneQuery = parser.parse(qry3)
def list3 = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()

def ids3 = list3.collect { it.student.id }
*/

//for AND, use intersect. For OR, use disjoint?
def set = ids.intersect(ids2) as Set
println "set => $set"

if(!set.isEmpty()){
    def students = fts.createQuery("from Student where id in (:ids)").setParameterList("ids", set.asList()).list()

    println "Matching students:"
    students.each { println it }
} else {
    println "No Hits"
}

fts.getTransaction().commit()

