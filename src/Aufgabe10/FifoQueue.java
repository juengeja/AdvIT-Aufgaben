package Aufgabe10;

public class FifoQueue {

	private ListElement listStart = null;

	public void put(String s) {

		if(listStart == null) {
			listStart = new ListElement(s, null);
		}else {
			ListElement newElement = new ListElement(s, null);
			listStart.nextElement = newElement;
		}

	}

	public String get() {

		if(listStart != null) {

			String s = listStart.getInformation();
			listStart = listStart.nextElement();
			return s;

		}else {
			return "Empty queue!";
		}


	}

	public class ListElement{

		private ListElement nextElement;
		private String information;

		public ListElement(String s, ListElement next) {
			this.information = s;
			this.nextElement = next;
		}

		public ListElement nextElement() {
			return this.nextElement;
		}

		public String getInformation() {
			return this.information;
		}

	}

}
