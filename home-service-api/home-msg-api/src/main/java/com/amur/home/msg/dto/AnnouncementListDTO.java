package com.amur.home.msg.dto;

import com.amur.home.msg.entity.HomeAnnouncement;
import com.amur.home.msg.entity.SystemAnnouncement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AnnouncementListDTO {
    public List<HomeAnnouncement> homeAnnouncementList;
    public List<SystemAnnouncement> systemAnnouncementList;
}
