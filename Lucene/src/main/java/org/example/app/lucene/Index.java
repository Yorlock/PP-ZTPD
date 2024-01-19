package org.example.app.lucene;

import org.apache.lucene.analysis.pl.PolishAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class Index {

        private String INDEX_DIRECTORY;

        public Index(String path) throws IOException {
                this.INDEX_DIRECTORY = path;

                // StandardAnalyzer analyzer = new StandardAnalyzer();
                // EnglishAnalyzer analyzer = new EnglishAnalyzer();
                PolishAnalyzer analyzer = new PolishAnalyzer();

                Directory directory = FSDirectory.open(Paths.get(INDEX_DIRECTORY));

                IndexWriterConfig config = new IndexWriterConfig(analyzer);
                IndexWriter w = new IndexWriter(directory, config);

                /*
                w.addDocument(buildDoc("Lucene in Action", "9781473671911"));
                w.addDocument(buildDoc("Lucene for Dummies", "9780735219090"));
                w.addDocument(buildDoc("Managing Gigabytes", "9781982131739"));
                w.addDocument(buildDoc("The Art of Computer Science", "9781250301695"));
                w.addDocument(buildDoc("Dummy and yummy title", "9780525656161"));
                */

                w.addDocument(buildDoc("Lucyna w akcji", "9780062316097"));
                w.addDocument(buildDoc("Akcje rosną i spadają", "9780385545955"));
                w.addDocument(buildDoc("Bo ponieważ", "9781501168007"));
                w.addDocument(buildDoc("Naturalnie urodzeni mordercy", "9780316485616"));
                w.addDocument(buildDoc("Druhna rodzi", "9780593301760"));
                w.addDocument(buildDoc("Urodzić się na nowo", "9780679777489"));

                w.close();
        }

        private static Document buildDoc(String title, String isbn) {
                Document doc = new Document();
                doc.add(new TextField("title", title, Field.Store.YES));
                doc.add(new StringField("isbn", isbn, Field.Store.YES));
                return doc;
        }
        }
