package Matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestMatcher {
	@Test
	public void namedCapturingGroup() {
		String url = "http://www.example.org/uid/alex/docid/1/title/MyFirstBlog";
		Pattern pattern = Pattern
				.compile("^.*/uid/(?<uid>.*)/docid/(?<docid>.*)/title/(?<title>.*)");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches()) {
			String uid = matcher.group("uid");
			String docid = matcher.group("docid");
			String title = matcher.group("title");
			System.out.println("uid:" + uid + ",docid:" + docid + ",title:"
					+ title);
		}
	}

}
