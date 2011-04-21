package com.lucenetest

import org.hibernate.search.Search
import org.apache.lucene.queryParser.QueryParser
import org.apache.lucene.util.Version
import org.apache.lucene.analysis.standard.StandardAnalyzer

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/21/11
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */

def fts = Search.getFullTextSession(HibernateUtil.getSession())

fts.beginTransaction()
String qry = "institution:harv"

def parser = new QueryParser(Version.LUCENE_30, "firstName", new StandardAnalyzer(Version.LUCENE_30))

def luceneQuery = parser.parse(qry)

def list = fts.createFullTextQuery(luceneQuery, Student.class, Education.class).list()

list.each {
    println it.class
//    println it.getStudent().getId()//class
}

def students = list.collect { it.student.id }

students.each { print it + " " }


fts.getTransaction().commit()

