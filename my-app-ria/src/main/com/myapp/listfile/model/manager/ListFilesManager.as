package com.myapp.listfile.model.manager
{
	import com.myapp.listfile.vos.FileList;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	
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
			var fileItem:FileList;
			var i:int;
			for each(var item:Object in fileList){
				fileItem = new FileList();
				fileItem.filePath = item.filePath;
				fileItem.fileName = item.fileName;
				fileItem.id = item.id;
				fileItem.updatetime = item.updatetime;
				_fileList.addItem(fileItem);
			}
			dispatchEvent(new Event("fileListChanged"));
		}
	}
}