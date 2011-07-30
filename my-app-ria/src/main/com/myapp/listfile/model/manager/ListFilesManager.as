package com.myapp.listfile.model.manager
{
	import com.myapp.listfile.vos.FileList;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	public class ListFilesManager extends EventDispatcher
	{
		private var _fileList:ArrayCollection;
		
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
			for(i=0;fileList.length;i=i+1){
				Alert.show("inside for " + i);
				fileItem = fileList.getItemAt(i) as FileList;
				Alert.show(fileItem.fileName);
				_fileList.addItem(fileItem);
			}
			dispatchEvent(new Event("fileListChanged"));
		}
	}
}