package com.epam.parser;

import com.epam.entity.PostCard;

public interface XmlEntityParser {
    PostCard parsePostCard(String fileName);
}
