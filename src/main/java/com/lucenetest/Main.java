package com.lucenetest;

import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/21/11
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Session s = HibernateUtil.getSession();
        FullTextSession fts = Search.getFullTextSession(s);

        fts.createIndexer(Student.class)
        .batchSizeToLoadObjects(30)
        .threadsForSubsequentFetching(4)
        .threadsToLoadObjects(2)
        .startAndWait();

        System.out.println("done");
    }
}
