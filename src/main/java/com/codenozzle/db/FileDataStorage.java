package com.codenozzle.db;

import com.codenozzle.model.FileData;

public class FileDataStorage extends EntityStorage<FileData> {

	@Override
	public FileData merge(FileData current, FileData updates) {
		return current;
	}

}
