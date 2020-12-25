package com.jiemeng.service;

import java.util.List;
import java.util.Map;

public interface ContentService {
    public Boolean parseContent(String keywords) throws Exception;

    public List<Map<String,Object>> searchPage(String keywords, int pageNo, int pageSize) throws Exception;
}
