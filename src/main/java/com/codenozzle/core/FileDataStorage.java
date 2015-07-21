package com.codenozzle.core;


public class FileDataStorage extends EntityStorage<FileData> {

	@Override
	public FileData merge(FileData current, FileData updates) {
		return current;
	}

}
