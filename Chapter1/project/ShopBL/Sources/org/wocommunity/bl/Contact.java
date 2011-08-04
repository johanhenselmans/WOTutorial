package org.wocommunity.bl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.webobjects.foundation.NSValidation;
import com.webobjects.foundation.NSValidation.ValidationException;

public abstract class Contact extends _Contact {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Contact.class);
	
	  private static final String sp = "\\!\\#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^\\_\\`\\{\\|\\}\\~";
	  private static final String atext = "[a-zA-Z0-9" + sp + "]";
	  private static final String atom = atext + "+"; //one or more atext chars
	  private static final String dotAtom = "\\." + atom;
	  private static final String localPart = atom + "(" + dotAtom + ")*"; //one atom followed by 0 or more dotAtoms.

	  //RFC 1035 tokens for domain names:
	  private static final String letter = "[a-zA-Z]";
	  private static final String letDig = "[a-zA-Z0-9]";
	  private static final String letDigHyp = "[a-zA-Z0-9-]";
	  public static final String rfcLabel = letDig + "(" + letDigHyp + "{0,61}" + letDig + ")?";
	  private static final String domain = rfcLabel + "(\\." + rfcLabel + ")*\\." + letter + "{2,6}";

	  //Combined together, these form the allowed email regexp allowed by RFC 2822:
	  private static final String addrSpec = "^" + localPart + "@" + domain + "$";
	  //now compile it:
	  public static final Pattern VALID_PATTERN = Pattern.compile( addrSpec );	    
	  
	  @Override
	public void validateForSave() throws ValidationException {
		super.validateForSave();
		if (email() == null){
			throw  new NSValidation.ValidationException("The email adress must be filled!");
		}
	}
	  
	  public String validateEmail(String s) throws NSValidation.ValidationException {

		    if (s==null)
		    	throw new NSValidation.ValidationException("Email address was not provided");
		    if (s.length()==0)
		        throw new NSValidation.ValidationException("Email address was not entered");
		    // now we start seriously, via pattern matching:

		    //Set the email pattern string
		    //  Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		      //Match the given string with the pattern
		      Matcher m = VALID_PATTERN.matcher(s);
		      //check whether match is found 
		      boolean matchFound = m.matches();
		      if (!matchFound)
		    	  throw new NSValidation.ValidationException("Email address was not OK");
		    return s;
	  }
	  

}
