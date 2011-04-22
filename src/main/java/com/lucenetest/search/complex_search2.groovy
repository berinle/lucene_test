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

def fts = Search.getFullTextSession(HibernateUtil.getSession())

fts.beginTransaction()
String qry1 = "-institution:harv +e_degreeYear:2010"
String qry2 = "type:wp"
//String qry3 = "+m_degreeCode:az +m_degreeYear:2009"
String qry3 = "+m_degreeCode:az +m_degreeYear:2010"

def parser = new QueryParser(Version.LUCENE_30, "firstName", new StandardAnalyzer(Version.LUCENE_30))

def luceneQuery = parser.parse(qry1)

def list = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()
list.each { println it }
def ids = list.collect { it.student.id }

//qry2 += " +id:(${ids.join(" ")})"
//println "query2: $qry2"

luceneQuery = parser.parse(qry2)

def list2 = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()

//list.each { println it.class }
def ids2 = list2.collect { it.student.id }


luceneQuery = parser.parse(qry3)
def list3 = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()

def ids3 = list3.collect { it.student.id }

//for AND, use intersect. For OR, use disjoint?
//println ids.intersect(ids2) as Set
println ids.intersect(ids2).intersect(ids3) as Set
