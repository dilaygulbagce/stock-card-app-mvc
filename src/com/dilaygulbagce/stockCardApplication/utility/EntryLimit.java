package com.dilaygulbagce.stockCardApplication.utility;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class EntryLimit extends PlainDocument{

	private int limit;
	
	public EntryLimit(int limit) {
		super();
		this.limit = limit;
		  
	}
	
	public void insertString(int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		if (string == null) {
			return;
		}
		
	    if ((getLength() + string.length()) <= limit) {
	      super.insertString(offset, string, attr);
	    }
	}
}
