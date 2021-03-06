/*
 * AllSumarizer v2
 * This file is part of AllSummarizer project; an implementation of the method
 * described in this paper:
 * http://dx.doi.org/10.1117/12.2004001
 * 
 * Copyright (C) 2013  Abdelkrime Aries <kariminfo0@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package kariminf.langpi.basic.std;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


import kariminf.langpi.basic.Segmenter;


public abstract class OpennlpSegmenter implements Segmenter {

	private static final String ressourcesSent = 
			"/sentenceDetection/";
	private static final String ressourcesWord = 
			"/wordTokenization/";
	
	private static final String punctuation = "\"'()[]{}!:;,?&.";
	
	private final String sentBin;
	private final String wordBin;
	
	public OpennlpSegmenter(String sentBin, String wordBin){
		this.sentBin = ressourcesSent + sentBin;
		this.wordBin = ressourcesWord + wordBin;
	}
	
	public List<String> splitToSentences(String text) {
		
		List<String> sentences = new ArrayList<String>();
		//List<String> returnedSentences = new ArrayList<String>();
		
		try {
			InputStream modelIn = getClass().getResourceAsStream(sentBin);
			SentenceModel model = new SentenceModel(modelIn);
			SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
			String[] initSentences = sentenceDetector.sentDetect(text);
			for(String snt : initSentences){
				sentences.add(snt);
			}
			modelIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sentences;
	}
	
	public List<String> segmentWords(String text) {
		
		List<String> wordsList = new ArrayList<String>();
	    
	    try {
	    	InputStream modelIn = getClass().getResourceAsStream(wordBin);;
			TokenizerModel model = new TokenizerModel(modelIn);
			TokenizerME tokenizer = new TokenizerME(model);
			String[] words = tokenizer.tokenize(text);
			for(String word : words)
				if (!punctuation.contains(word))
					wordsList.add(word);
			
			modelIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return wordsList;
	}
	

}
