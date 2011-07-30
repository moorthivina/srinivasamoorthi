package com.myapp.listfile.event
{
	import flash.events.Event;

	public class ListFilesEvent extends Event
	{
		public static const LIST:String="LIST";
		
		public function ListFilesEvent(type : String, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);
		}
	}
}