package com.myapp.listfile.vos
{
	[RemoteClass(alias="com.myapp.been.Files")]
	public class FileList
	{
		public function FileList(){
			
		}
		public var id:int;
		public var fileName:String;
		public var filePath:String;
		public var updatetime:Date;
		
		public function set setId(id:int):void {
			this.id = id;
		}
		
		public function set setFileName(fileName:String):void {
			this.fileName = fileName;
		}

		public function set setFilePath(filePath:String):void {
			this.filePath = filePath;
		}
		
		public function set setUpdateTime(updateTime:Date):void {
			this.updatetime = updateTime;
		}
	}
}