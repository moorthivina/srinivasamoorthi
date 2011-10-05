package com.myapp.common.model
{
	import com.myapp.common.event.ContentEvent;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.controls.Alert;
	[Bindable]
	public class ContentModel extends EventDispatcher
	{
		private var _dispatcher:IEventDispatcher;

		private var _url:String;

		[Bindable(event="urlChange")]
		public function get url():String 
		{
			return _url;
		}
		
		public function set modelUrl(url:String):void {
			_url = url;
			dispatchEvent(new Event("urlChange"));			
		}

		public function ContentModel(dispatcher:IEventDispatcher)
		{
			this._dispatcher = dispatcher;
		}

		public function initiate():void {
			_dispatcher.dispatchEvent(new ContentEvent(ContentEvent.CRAWLPAGE));
		}
	}
}