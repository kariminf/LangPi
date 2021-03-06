
package kariminf.langpi.basic.french;

import java.util.ArrayList;
import java.util.List;

import org.tartarus.snowball.ext.FrenchStemmer;

import kariminf.langpi.basic.Stemmer;

public class FrStemmer implements Stemmer {

	private FrenchStemmer stemmer = new FrenchStemmer();
	
	@Override
	public List<String> stemListWords(List<String> listWords) {

		List<String> stemmedLW = new ArrayList<String>();
		
		for (String word: listWords)
			stemmedLW.add(stemWord(word));
		
		return stemmedLW;
	}
	
	
	public String stemWord (String word){
		stemmer.setCurrent(word);
		stemmer.stem();
		return stemmer.getCurrent();
	}
	
	public static void main(String[] args) {
		FrStemmer Stemmer=new FrStemmer();
		List<String> lst = new ArrayList<String>();
		lst.add("reprendrait");
		lst.add("information");
		lst.add("détournement");
		lst.add("applaudissement");
	
		lst = Stemmer.stemListWords(lst);
		System.out.println(lst.toString());	

	}
	
	
}





