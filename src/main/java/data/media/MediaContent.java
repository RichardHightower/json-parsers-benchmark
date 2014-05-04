package data.media;

import org.boon.Lists;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MediaContent implements java.io.Serializable
{
	public Media media;
	public List<Image> images;

    public static MediaContent mediaContent() {

        List<Image> images;

        images = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            Image image = new Image("/foo" + index, "Foo" + index, 5 + index, 10 + index, Image.Size.SMALL);
            images.add(image);
        }
        Media media = new Media("/fooMedia" , "Foo Media", 100, 100, "mpeg", 1L, 1L, 300, true,
                Lists.list("Rick Hightower", "Cowboy coder", "Ruediger Moeller"), Media.Player.FLASH, "2004");

        return new MediaContent(media, images);
    }


    public MediaContent() {}

	public MediaContent (Media media, List<Image> images) {
		this.media = media;
		this.images = images;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MediaContent that = (MediaContent) o;

		if (images != null ? !images.equals(that.images) : that.images != null) return false;
		if (media != null ? !media.equals(that.media) : that.media != null) return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = media != null ? media.hashCode() : 0;
		result = 31 * result + (images != null ? images.hashCode() : 0);
		return result;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[MediaContent: ");
		sb.append("media=").append(media);
		sb.append(", images=").append(images);
		sb.append("]");
		return sb.toString();
	}

    public void setMedia(Media media) {
        this.media = media;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Media getMedia() {
        return media;
    }

    public List<Image> getImages() {
        return images;
    }
}
