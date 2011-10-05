package com.myapp.listfile.model
{
	import com.myapp.listfile.event.ListFilesEvent;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;

	public class ListFilesModel extends EventDispatcher
	{
		public var _fileList:ArrayCollection;
		
		[Bindable (event="fileListChanged")]
        public function get fileList():ArrayCollection
        {
            return _fileList;
        }

		public function set fileList(fileList:ArrayCollection):void
        {
            this._fileList = fileList;
            dispatchEvent(new Event("fileListChanged"));
        }

		/** This property is injected by the application. */
		public var _dispatcher : IEventDispatcher;
		
		public function ListFilesModel(dispatcher:IEventDispatcher)
		{
			this._dispatcher = dispatcher;
		}

		public function list():void {
			var event:ListFilesEvent = new ListFilesEvent(ListFilesEvent.LIST);
			_dispatcher.dispatchEvent(event);
		}
		
		public function startCrawl():void {
			var event:ListFilesEvent = new ListFilesEvent(ListFilesEvent.STARTCRAWL);
			_dispatcher.dispatchEvent(event);
		}
	}
}