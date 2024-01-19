package org.example.app.lucene;

import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.pl.PolishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String INDEX_DIRECTORY = "D:\\Dominik\\Desktop\\Studia\\9semestr\\ZTPD\\Lucene\\src\\main\\java\\org\\example\\app\\lucene\\data";
        Index index = new Index(INDEX_DIRECTORY);
        Search search = new Search(INDEX_DIRECTORY);

        String querystr = "*:*";

        search.runQuery(querystr);

        /*
        7.
        a) String querystr = "dummy";
            Found 1 matching docs.
        b) String querystr = "and";
            Found 1 matching docs.
        */

        /*
        9.
        a) String querystr = "dummy";
            Found 2 matching docs.
            Znajduje dodatkowo odmieniowe wersje słów
        b) String querystr = "and";
            Found 0 matching docs.
            Blokada "podstawowych" słów
        */

        /*
        12.
        a) String querystr = "isbn:9780062316097";
        b) String querystr = "urodzić";
        c) String querystr = "rodzić";
        d) String querystr = "ro*";
        e) String querystr = "ponieważ";
        f) String querystr = "Lucyna AND akcja";
        g) String querystr = "akcja AND NOT Lucyna";
        h) String querystr = "\"naturalnie morderca\"~2";
        i) String querystr = "\"naturalnie morderca\"~1";
        j) String querystr = "\"naturalnie morderca\"~0";
        k) String querystr = "naturalne";
        l) String querystr = "naturalen~";
        */

        /*
        Answers:
        - Brak usuwania plików indeksu spowoduje wyszukiwanie po obecnie utworzonych indeksach oraz po wcześniej utworzonych
        - Zwiększa się numeracja indeksu pliku
        */
    }
}


