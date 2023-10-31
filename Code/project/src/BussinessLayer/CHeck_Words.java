package BussinessLayer;

import java.awt.Color;
import java.text.BreakIterator;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import DataAccesLAyer.Text_Read;

public class CHeck_Words {

	static Text_Read obj=new Text_Read();
	
	public ArrayList<String> errorlist2=obj.ErrorList();
	
	
	
	public void String_Breaker(String textArea) {
	ArrayList<String> words = new ArrayList<String>();
	BreakIterator breakIterator = BreakIterator.getWordInstance();		
    breakIterator.setText(textArea);
    int lastIndex = breakIterator.first();
    while (BreakIterator.DONE != lastIndex) {
        int firstIndex = lastIndex;
        lastIndex = breakIterator.next();
        if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(textArea.charAt(firstIndex))) {
            words.add(textArea.substring(firstIndex, lastIndex));
          
        }
    }
	
	for ( int i=0;i<words.size();i++ ) {
	
	obj.connection_FUN(words.get(i));
	
	}
	}
	public JTextArea Hilight(JTextArea textArea_1) {
		if(errorlist2.isEmpty()) {
			  
		}
		else {
		for(int i=0;i<errorlist2.size();i++) {
		Highlighter highlighter = textArea_1.getHighlighter();
        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);          
        int p0 = textArea_1.getText().indexOf(errorlist2.get(i));
        int p1 = p0 + errorlist2.get(i).length();

        try {
            
            highlighter.addHighlight(p0, p1, painter);
        } catch (BadLocationException e1) {
        	
        }
		}
		
		return textArea_1;
		}
		return null;
	}

	public boolean check_List() {
		
		if(errorlist2.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
		
	}
	
}
