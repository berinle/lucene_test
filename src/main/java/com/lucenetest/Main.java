package com.lucenetest;

import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import java.util.ArrayList;
import java.util.List;

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
        List<Class> classes = new ArrayList<Class>() {{
            add(Student.class);
            add(Education.class);
            add(Medical.class);
            add(Publication.class);
            add(Program.class);
            add(Score.class);
        }};
        FullTextSession fts = Search.getFullTextSession(s);

        fts.createIndexer(classes.toArray(new Class[1]))
        .batchSizeToLoadObjects(30)
        .threadsForSubsequentFetching(4)
        .threadsToLoadObjects(2)
        .startAndWait();

        System.out.println("done");
    }
}
