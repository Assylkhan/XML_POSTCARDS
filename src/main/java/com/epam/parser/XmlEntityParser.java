package com.epam.parser;

import com.epam.entity.PostCard;

import java.io.InputStream;

public interface XmlEntityParser {
    PostCard parsePostCard(InputStream inputStream);
}
