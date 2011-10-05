package com.myapp.common.event
{
	import flash.events.Event;
	
	public class ContentEvent extends Event
	{
		public static const CRAWLPAGE:String="crawlPage";
		
		public function ContentEvent(type : String, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);
		}
	}
}