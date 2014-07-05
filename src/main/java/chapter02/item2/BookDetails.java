package chapter02.item2;


public class BookDetails
{
    private final int pageNumbers;
    private final int isbn10;
    private final int isbn13;
    private final String publishDate;
    private final BookLang bookLang;

    private BookDetails(BuilderBookDetails builder)
    {
        this.pageNumbers = builder.pageNumbers;
        this.isbn10 = builder.isbn10;
        this.isbn13 = builder.isbn13;
        this.publishDate = builder.publishDate;
        this.bookLang = builder.bookLang;
    }

    public static enum BookLang
    {
        EN,ES,PT_BR,FR
    }

    public static class BuilderBookDetails implements Builder<BookDetails>
    {
        private final int pageNumbers;
        private final String publishDate;
        private final BookLang bookLang;

        private int isbn10 = 0;
        private int isbn13 = 0;

        public BuilderBookDetails(int pageNumbers,String publishDate,BookLang bookLang){

            assertIsNotNull(publishDate, "Publish date is requeried");
            assertIsNotNull(publishDate, "Language book is requeried");

            this.pageNumbers = pageNumbers;
            this.publishDate = publishDate;
            this.bookLang = bookLang;
        }

        public BuilderBookDetails isbn10(int isbn10)
        {
            this.isbn10 = isbn10;
            return this;
        }

        public BuilderBookDetails isbn13(int isbn13)
        {
            this.isbn13 = isbn13;
            return this;
        }

        public BookDetails build()
        {
            return new BookDetails(this);
        }

        public void assertIsNotNull(Object object, String msgError)
        {
            if(object==null)
                throw new IllegalArgumentException(msgError);
        }
    }

    public int getPageNumbers()
    {
        return pageNumbers;
    }

    public int getIsbn10()
    {
        return isbn10;
    }

    public int getIsbn13()
    {
        return isbn13;
    }

    public String getPublishDate()
    {
        return publishDate;
    }

    public BookLang getBookLang()
    {
        return bookLang;
    }
}


