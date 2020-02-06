package acp;

public class ApplicationController {
	public String process(String nextPage) {
		// Pass request to CommandHelper to determine what response to give to this request.
		return CommandHelper.getPage(nextPage);
	}
}