package com.mukho.ranksystem.Service;

import java.util.List;

public interface RecordService {

    List<List> getRecord(String name);

    List<List> getRelativeRecord(String user1, String user2);

}
