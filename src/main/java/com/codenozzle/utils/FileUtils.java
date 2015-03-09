package com.codenozzle.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;

public class FileUtils {

	public static BufferedImage convertInputStreamToBufferedImage(final InputStream inputStream) throws IOException {
	    BufferedImage image = null;
	    if (inputStream != null) {
	        image = ImageIO.read(inputStream);
	    }
	    return image;
	}
	
	public static String getFileType(String fileName) {
		return fileName.substring(fileName.indexOf(".") + 1);
	}
	
	public static BufferedImage getBufferedImage(final InputStream inputStream, final String fileName) throws IOException {
		BufferedImage image = null;
		Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix(getFileType(fileName));
		ImageReader imageReader = (ImageReader) readers.next();
		if (imageReader != null) {
			ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
			imageReader.setInput(imageInputStream, false);
			image = imageReader.read(0);
		}
		return image;
	}

	public static byte[] getByteArray(final InputStream inputStream) throws IOException {
		if (inputStream != null) {
			return IOUtils.toByteArray(inputStream);
		}
		return null;
	}
	
	public static BufferedImage getThumbnail(final BufferedImage fullImage) {
		BufferedImage scaledImage = null;
		if (fullImage != null) {
			scaledImage = Scalr.resize(fullImage, 150);
		}
		return scaledImage;
	}

	public static byte[] getThumbnailAsByteArray(final BufferedImage bufferedImage, final String fileType) throws IOException {
		if (bufferedImage != null) {
			BufferedImage thumbnail = getThumbnail(bufferedImage);
			if (thumbnail != null) {
				return getByteArray(thumbnail, fileType);
			}
		}
		return null;
	}
	
	public static byte[] getByteArray(final BufferedImage bufferedImage, String fileType) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		if (bufferedImage != null) {
			ImageIO.write(bufferedImage, fileType, baos);
		}
		return baos.toByteArray();
	}

}
