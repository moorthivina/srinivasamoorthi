package com.myapp.crawler.event
{
	import flash.events.Event;

	public class CrawlerEvent extends Event
	{
		public static const STARTCRAWL:String="startCrawl";
		
		public function CrawlerEvent(type : String, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);
		}
	}
}