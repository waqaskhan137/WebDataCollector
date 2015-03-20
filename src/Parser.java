import java.net.UnknownHostException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @contributor rmw
 * @Purpose: Only handles the Parsing of the web pages
 * 
 * @Task - Get any element of page - Efficiency - Logging
 *
 */
class Parser {

	void Parsing(ArrayList<String> html) throws UnknownHostException {

		// getting body tag or any element, Not sure about this will look at t
		// later
		String tag = "body";

		// getting body text of the page
		ArrayList<String> text = new ArrayList<String>();

		for (int i = 0; i < html.size(); i++) {
			String page = html.get(i);
			Document nD = new Document(page);

			org.jsoup.select.Elements resultLinks = ((Element) nD).select(tag);

			// adding it the Array List
			// conveting it to the string again? not sure but will look at at
			// later
			text.add(resultLinks.toString());
		}

		// DB object
		DBHandler db = new DBHandler();
		// Sending it to the DB
		db.insert(text);

	}

}