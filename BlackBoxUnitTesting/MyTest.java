
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.TextParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

     

class MyTest {
         
     /**
      * Test {@link${HtmlParseData}#getText()}
      * 
      * This testcase involves HtmlParseData class, as it 
      * was noticed that text that was being called from
      * HtmlParseData class getText() method was in the 
      * lower case. Testing involves testing getText()
      * method as bug might be present in this and setText()
      * as this method is for setting text.
      * <p>
      * As the nature of the bug is unknown there is possibility 
      * that variety of characters might be changed, though
      * only upper to lower case seems important.
      * 
      * The output obtained has all characters same but
      * only upper cases has been converted into lower cases
      * <p>
      * As only upper cases has been turned into lower
      * cases the bug most likely to be toLowerCase, 
      * and it might be present in either setText() or 
      * getText() as no other method is being called. 
	  */
	@Test
	public void lowercasetest() {
	HtmlParseData html = new HtmlParseData();
	String normaltext = "Lets Test This, 0257845, abcd, ABCD, AaBbCc, +-/@.<>?,"
			+ "//:[]{}, @#";
	html.setText(normaltext);
	System.out.println(normaltext+" ==//== "+ "\n" +html.getText());
	assertEquals(normaltext,html.getText());
	}
	/**
	 * Test {@link${TextParseData}#getTextContent()}
	 * 
	 * Testcase test TextParseData as it was noticed that
	 * all 0s were being replaced by 1 in data 
	 * that was being called from TextParseData using 
	 * getTextContent method. Other method that was 
	 * used in testing was setTextContent(), as this method 
	 * was required to set content of textdata.
	 * <p>
	 * The input given here has variety of int and doubles
	 * with zero to check in which case 0 is replaced by 1
	 * Is it important to note that input is string. 
	 * 
	 * The output obtained shows that 0 is replaced by 1
	 * regardless of what number format it had. Keeping 
	 * all other numbers same.
	 * <p>
	 * Possible error is most likely present in setTextContent
	 * or getTextContent as no other method is being called and 
	 * it is unlikely they are passing this input to any other 
	 * method, the bug is precisely replacing 0 with 1
	 */
	@Test
	public void checkTextData() {
	    TextParseData textdata = new TextParseData();
	    String textdataexample = "0,00,1,010,22,3, 4, 5, 6, 7, 8, 9, 100, 0.010";
	    textdata.setTextContent(textdataexample);
	    System.out.println(textdataexample+ " ==//== "+ "\n" +textdata.getTextContent());
	    assertEquals(textdataexample,textdata.getTextContent());   
	}
	/**
	 * Test {@link${HtmlParseData}#getHtml()}
	 * This case tests HtmlParseData class as all
	 * Html is converted into lower class including
	 * html Tags<DOCTYPE>. This class has tow method
	 * to setHmtl and getHtml, both are being tested as
	 * html was called through getHtml method. 
	 * <p>
	 * Input given is some Html with uppercase tags,
	 * Words and some other characters, to see how 
	 * they are affected. 
	 * 
	 * The output obtained was only upper case
	 * for tags and words was converted into lower
	 * case very much like toLowerCase. as all other 
	 * characters are same.
	 * <p>
	 * This demonstrates the bug is precisley 
	 * identifying uppercase letters and converting
	 * them to lower case just like getText or setText
	 * of this class. 
	 */
	@Test
	public void testHtmlcase() {
		HtmlParseData htmlcase = new HtmlParseData();
		String htmlexample = "<H1>Hello</H1><p>Hello World</p><p>+-*/123</p><p>ABCDS</p>";
		htmlcase.setHtml(htmlexample);
		System.out.println(htmlexample+" ==//==" + "\n" + htmlcase.getHtml());
		assertEquals(htmlexample,htmlcase.getHtml());
		
	}
	/**
	 * Test {@link${MyCrawler})}
     * 
     * TestCase tests MyCrawler class to test
     * should visit policy as running crawler
     * identified to potential problems with should 
     * visit policy first two pages Reinforcement_
     * learning and Unsupervised_learning was not being
     * processed and second was shouldvisit policy allowing 
     * private urls pages to be crawled. 
     * <p>
     * The input used was the private url IDA.html,
     * Reinforcement and Unsupervised page urls, and some 
     * other urls to see how shouldVisit policy get applied.
     * Though the assertNotNull test was not successful
     * however identified problem was should visit policy was 
     * allowing to process private urls pages while ignoring 
     * above mentioned urls pages.
     * <p>
     * The error identified was that the shouldVisit policy
     * in MyCrawler class was supposed to override the policy
     * in WebCrawler class however shouldPolicy in MyCrawler 
     * is not functioning, the bug might be WebCrawler shouldVisit
     * policy. As it's policy is still applied. While shouldVisit
     * policy is MyCrawler is not even being called.
	 */
    @Test
	public void testurl() throws Exception {
		MyCrawler mycr = new MyCrawler();
		CrawlConfig configure = new CrawlConfig();
		String crawlStorageFolder = "data/";
		int noofcrawls = 1;
		configure.setCrawlStorageFolder(crawlStorageFolder);
		configure.setIncludeBinaryContentInCrawling(false);
		configure.setMaxDepthOfCrawling(-1);
		configure.setMaxOutgoingLinksToFollow(5000);
		
		PageFetcher pf = new PageFetcher(configure);
		RobotstxtConfig rsc = new RobotstxtConfig();
		RobotstxtServer rss = new RobotstxtServer(rsc,pf);
		CrawlController cont = new CrawlController(configure, pf, rss);
		cont.addSeed("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2private/IDA.html");
		//cont.addSeed("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Arthur_Samuel.html");
		//cont.addSeed("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Supervised_learning.html");
		//cont.addSeed("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Unsupervised_learning.html");
		//cont.addSeed("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Reinforcement_learning.html");
		cont.start(MyCrawler.class, noofcrawls); 
		Page page = new Page(null);
		TextParseData textParseData = new TextParseData();
		HtmlParseData htmlParseData = new HtmlParseData();
		String text = textParseData.getTextContent();
		String html = htmlParseData.getHtml();
		System.out.println(page.getWebURL());
		System.out.println(html);
		System.out.println(text);
        assertNotNull(((TextParseData)page.getParseData())); 
	}
}





