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
//String qry = "+institution:harv +type:wp"
String qry1 = "+institution:harv"
String qry2 = "+type:wp"

def parser = new QueryParser(Version.LUCENE_30, "firstName", new StandardAnalyzer(Version.LUCENE_30))

def luceneQuery = parser.parse(qry1)

def list = fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list()

//list.each { println it.class }

luceneQuery = parser.parse(qry2)

list.addAll(fts.createFullTextQuery(luceneQuery, Student.class, Education.class, Medical.class, Publication.class).list())

//list.each { println it.class }

def ids = list.collect { it.student.id }

println ids
