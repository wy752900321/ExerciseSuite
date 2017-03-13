package com.tarena.entity;

public class Book extends Product implements java.io.Serializable{
	
	private static final long serialVersionUID = -4585571510805703660L;
		private String author;
		private String  publishing;
		private long publishtime;
		private String catalogue;// 图书描述
		public String getCatalogue() {
			return catalogue;
		}
		public void setCatalogue(String catalogue) {
			this.catalogue = catalogue;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getPublishing() {
			return publishing;
		}
		public void setPublishing(String publishing) {
			this.publishing = publishing;
		}
		public long getPublishtime() {
			return publishtime;
		}
		public void setPublishtime(long publishtime) {
			this.publishtime = publishtime;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((author == null) ? 0 : author.hashCode());
			result = prime * result
					+ ((catalogue == null) ? 0 : catalogue.hashCode());
			result = prime * result
					+ ((publishing == null) ? 0 : publishing.hashCode());
			result = prime * result + (int) (publishtime ^ (publishtime >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (author == null) {
				if (other.author != null)
					return false;
			} else if (!author.equals(other.author))
				return false;
			if (catalogue == null) {
				if (other.catalogue != null)
					return false;
			} else if (!catalogue.equals(other.catalogue))
				return false;
			if (publishing == null) {
				if (other.publishing != null)
					return false;
			} else if (!publishing.equals(other.publishing))
				return false;
			if (publishtime != other.publishtime)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Book [author=" + author + ", catalogue=" + catalogue
					+ ", publishing=" + publishing + ", publishtime="
					+ publishtime + "]";
		}	
		
}
