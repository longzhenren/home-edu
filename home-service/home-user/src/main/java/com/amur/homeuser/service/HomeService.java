package com.amur.homeuser.service;

public interface HomeService {
    public GetHomeBaseResp getHomeBaseInfo(String homeId);
    public GetHomeBaseResp getHomeDetailInfo(String homeId);
    public GetHomeListResp getHomeList();
    public CreateHomeResp createHome();
    public UpdateHomeResp updateHome(UpdateHomeReq request);
    public DeleteHomeResp deleteHome(DeleteHomeReq request);
    public GetHomeUserListResp getHomeUserList(GetHomeUserListReq request);
    public UpdateHomeUserResp updateHomeUser(UpdateHomeUserReq request);
    public DeleteHomeUserReq deleteHomeUser(DeleteHomeUserResp request);
    public SetHomeAdminReq setHomeAdmin(SetHomeAdminResp request);
    public AddHomeImageResp addHomeImage(AddHomeImageReq ?);

}
