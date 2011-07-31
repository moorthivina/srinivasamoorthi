package com.myapp.listfile.model.manager
{
	import com.myapp.listfile.vos.FileList;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	public class ListFilesManager extends EventDispatcher
	{

		public var _fileList:ArrayCollection;
		
		[Bindable (Event="fileListChanged")]
        public function get fileList():ArrayCollection
        {
            return _fileList;
        }
        
		public function ListFilesManager()
		{
		}
		
		public function updateList(fileList:ArrayCollection ):void {
			_fileList = new ArrayCollection();
			Alert.show("Result returned " + fileList.length);
			var fileItem:FileList;
			var i:int;
			for(i=0;i<fileList.length;i=i+1){
				Alert.show("1. inside for " + i);
				fileItem = fileList.getItemAt(i) as FileList;
				_fileList.addItem(fileItem);
			}
			dispatchEvent(new Event("fileListChanged"));
		}
	}
}