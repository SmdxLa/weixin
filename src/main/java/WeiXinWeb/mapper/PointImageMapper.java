package WeiXinWeb.mapper;

import WeiXinWeb.pojo.PointImage;

import java.util.List;

public interface PointImageMapper {

    //全部图片信息
    List<PointImage> selectAllPointImages();

    PointImage selectPointImageByName(String name);

}
