package info.thecodinglive.validator;

public class BookResponse {
	public BookResponse(Book book, PageInfo pageInfo) {
		this.book = book;
		this.pageInfo = pageInfo;
	}

	public BookResponse() {

	}

	private Book book;

	private PageInfo pageInfo = new PageInfo();

	public static final BookResponse EMPTY = new BookResponse();

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}


	private class PageInfo {
		private Integer page;
		private Integer itemCount;

		public PageInfo(Integer page, Integer itemCount) {
			this.page = page;
			this.itemCount = itemCount;
		}

		public PageInfo() {
		}
	}
}
