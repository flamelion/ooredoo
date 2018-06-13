package test.model;


import java.time.LocalDate;
import java.util.ArrayList;

public class Vou {
	 private String name;
	 private double averagePrice;
	 private int volume;
	 private String hyperlinktest;
	 private String[] selection;
	 public String selected_selection="";
	 private LocalDate time;
	 public LocalDate getTime() {
		return time;
	}
	 
	public String getHyperlinktest() {
		return hyperlinktest;
	}

	public void setHyperlinktest(String hyperlinktest) {
		this.hyperlinktest = hyperlinktest;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}
	public Vou()
	{
		 time=LocalDate.now();
	}
	public Vou(String name,double averagePrice,int volumn,String hyper)
	 {
		 time=LocalDate.now();
		 this.name=name;
		 this.averagePrice=averagePrice;
		 this.volume=volumn;
		 this.hyperlinktest=hyper;
	 }
		public String getName() {
			return name;
		}

		public double getAveragePrice() {
			return averagePrice;
		}

		public int getVolume() {
			return volume;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAveragePrice(double averagePrice) {
			this.averagePrice = averagePrice;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}
		public String getSelection() {
			String s="";
			for(int i=0;i<selection.length;i++)
			{
				s+=selection[i];
				if(i+1!=selection.length)
						s+=",";
			}
			return s;
		}
		public void setSelection(String[] selection) {
			this.selection = selection;
		}
		public String getSelected_selection() {
			return selected_selection;
		}
		public void setSelected_selection(String selected_selection) {
			this.selected_selection = selected_selection;
		}
		
		
}
