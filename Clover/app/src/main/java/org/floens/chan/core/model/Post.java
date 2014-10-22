/*
 * Clover - 4chan browser https://github.com/Floens/Clover/
 * Copyright (C) 2014  Floens
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.floens.chan.core.model;

import android.text.SpannableString;
import android.text.TextUtils;

import org.floens.chan.ChanApplication;
import org.floens.chan.chan.ChanUrls;
import org.floens.chan.core.loader.ChanParser;
import org.floens.chan.ui.view.PostView;
import org.jsoup.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contains all data needed to represent a single post.
 */
public class Post {
    private static final Random random = new Random();

    public static String generateTitle(Post post) {
        return generateTitle(post, 100);
    }

    public static String generateTitle(Post post, int maxLength) {
        if (!TextUtils.isEmpty(post.subject)) {
            return post.subject;
        } else if (!TextUtils.isEmpty(post.comment)) {
            return "/" + post.board + "/ - " + post.comment.subSequence(0, Math.min(post.comment.length(), maxLength)).toString();
        } else {
            return "/" + post.board + "/" + post.no;
        }
    }

    public String board;
    public int no = -1;
    public int resto = -1;
    public boolean isOP = false;
    public String date;
    public String name = "";
    public CharSequence comment = "";
    public String subject = "";
    public String tim;
    public String ext;
    public String filename;
    public int replies = -1;
    public int imageWidth;
    public int imageHeight;
    public boolean hasImage = false;
    public String thumbnailUrl;
    public String imageUrl;
    public boolean sticky = false;
    public boolean closed = false;
    public boolean archived = false;
    public String tripcode = "";
    public String id = "";
    public String capcode = "";
    public String country = "";
    public String countryName = "";
    public long time = -1;
    public boolean isSavedReply = false;
    public String title = "";
    public int fileSize;
    public int images = -1;
    public String rawComment;
    public String countryUrl;
    public boolean spoiler = false;

    public boolean deleted = false;

    /**
     * This post replies to the these ids
     */
    public List<Integer> repliesTo = new ArrayList<>();

    /**
     * These ids replied to this post
     */
    public List<Integer> repliesFrom = new ArrayList<>();

    public final ArrayList<PostLinkable> linkables = new ArrayList<>();
    public boolean parsedSpans = false;
    public SpannableString subjectSpan;
    public SpannableString nameSpan;
    public SpannableString tripcodeSpan;
    public SpannableString idSpan;
    public SpannableString capcodeSpan;
    public CharSequence nameTripcodeIdCapcodeSpan;

    /**
     * The PostView the Post is currently bound to.
     */
    private PostView linkableListener;

    public Post() {
    }

    public void setLinkableListener(PostView listener) {
        linkableListener = listener;
    }

    public PostView getLinkableListener() {
        return linkableListener;
    }

    /**
     * Finish up the data
     *
     * @return false if this data is invalid
     */
    public boolean finish() {
        if (board == null)
            return false;

        if (no < 0 || resto < 0 || date == null || time < 0)
            return false;

        isOP = resto == 0;

        if (isOP && (replies < 0 || images < 0))
            return false;

        if (filename != null && ext != null && imageWidth > 0 && imageHeight > 0 && tim != null) {
            hasImage = true;
            imageUrl = ChanUrls.getImageUrl(board, tim, ext);
            filename = Parser.unescapeEntities(filename, false);

            if (spoiler) {
                Board b = ChanApplication.getBoardManager().getBoardByValue(board);
                if (b != null && b.customSpoilers >= 0) {
                    thumbnailUrl = ChanUrls.getCustomSpoilerUrl(board, random.nextInt(b.customSpoilers) + 1);
                } else {
                    thumbnailUrl = ChanUrls.getSpoilerUrl();
                }
            } else {
                thumbnailUrl = ChanUrls.getThumbnailUrl(board, tim, ext);
            }
        }

        if (!TextUtils.isEmpty(country)) {
            Board b = ChanApplication.getBoardManager().getBoardByValue(board);
            countryUrl = b.trollFlags ? ChanUrls.getTrollCountryFlagUrl(country) : ChanUrls.getCountryFlagUrl(country);
        }

        ChanParser.getInstance().parse(this);

        return true;
    }
}
