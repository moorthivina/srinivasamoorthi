package com.myapp.crawler.model
{
	
	import com.myapp.crawler.event.CrawlerEvent;
	
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;

	public class CrawlerModel extends EventDispatcher
	{
		
		/** This property is injected by the application. */
		public var _dispatcher : IEventDispatcher;
		
		public function CrawlerModel(dispatcher:IEventDispatcher)
		{
			this._dispatcher = dispatcher;
		}

		public function startCrawl():void {
			var event:CrawlerEvent = new CrawlerEvent(CrawlerEvent.STARTCRAWL);
			_dispatcher.dispatchEvent(event);
		}
	}
}