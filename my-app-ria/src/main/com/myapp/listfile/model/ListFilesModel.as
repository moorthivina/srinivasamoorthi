package com.myapp.listfile.model
{
	import com.myapp.listfile.event.ListFilesEvent;
	
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;

	public class ListFilesModel extends EventDispatcher
	{
		
		public var _fileList:ArrayCollection;
		[Bindable (event="fileListChanged")]
        public function get fileList():ArrayCollection
        {
        	Alert.show("Returned to model's filelist change event");
            return _fileList;
        }

		public function set fileList(fileList:ArrayCollection):void
        {
            this._fileList = fileList;
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
	}
}