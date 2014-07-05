package chapter02.item2;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class BookDetailsTest
{

    @Test
    public void test_builder()
    {
        BookDetails bookDetailsWithIsbn10 = new BookDetails
                .BuilderBookDetails(980, "23/01/2009", BookDetails.BookLang.EN)
                .isbn10(10920202).build();


        assertThat(bookDetailsWithIsbn10.getIsbn13()).isEqualTo(0);
        assertThat(bookDetailsWithIsbn10.getIsbn10()).isNotEqualTo(0);
    }
}
