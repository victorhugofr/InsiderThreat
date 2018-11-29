package br.ufrn.imd.lp2.io;
public class HTTP extends AbstractSuper {

	private String url;
	
	public HTTP (String url) {
		this.setActivity(url);
	}

	public String getActivity() {
		return url;
	}

	public void setActivity(String activity) {
		this.url = activity;
	}
	
	public void show() {
		System.out.println(getActivity());
	}

}
