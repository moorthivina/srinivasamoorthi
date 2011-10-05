package com.myapp.common.model.manager
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.controls.Alert;
	
	public class ContentManager extends EventDispatcher
	{

		private var _url:String;
		
		[Bindable (Event="urlChange")]
        public function get url():String
        {
            return _url;
        }
        
		public function ContentManager()
		{
		}
		
		public function loadUrl(url:String):void {
			_url = url;
			dispatchEvent(new Event("urlChange"));
		}
		
		public function loadModule(url:String):void {
			loadUrl("com/myapp/crawler/Crawler.swf");
			// loadUrl("TestModule.swf");
		}

	}
}