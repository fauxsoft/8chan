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
package org.floens.chan.chan;

import java.util.Locale;

public class InfinityChanUrls implements ChanUrlsInterface {
    public static final String TAG = "8chan";
    private String scheme;

    @Override
    public String getChan(){
        return TAG;
    }

    public void loadScheme(boolean useHttps) {
        scheme = useHttps ? "https" : "http";
    }

    public String getCatalogUrl(String board) {
        return scheme + "://8chan.co/" + board + "/catalog.json";
    }

    public String getPageUrl(String board, int pageNumber) {
        return scheme + "://8chan.co/" + board + "/" + (pageNumber + 1) + ".json";
    }

    public String getThreadUrl(String board, int no) {
        return scheme + "://8chan.co/" + board + "/res/" + no + ".json";
    }

    public String getCaptchaChallengeUrl() {
        return "";
    }

    public String getCaptchaImageUrl(String challenge) {
        return "";
    }

    public String getImageUrl(String board, String code, String extension) {
        return scheme + "://8chan.co/" + board + "/src/" + code + "." + extension;
    }

    public String getThumbnailUrl(String board, String code, String extension) {
        return scheme + "://8chan.co/" + board + "/thumb/" + code + "." + extension;
    }

    public String getSpoilerUrl() {
        return "";
    }

    public String getCustomSpoilerUrl(String board, int value) {
        return "";
    }

    public String getCountryFlagUrl(String countryCode) {
        return "";
    }

    public String getTrollCountryFlagUrl(String countryCode) {
        return "";
    }

    public String getBoardsUrl() {
        return scheme + "://8chan.co/boards.json";
    }

    public String getReplyUrl(String board) {
        return "";
    }

    public String getDeleteUrl(String board) {
        return "";
    }

    public String getBoardUrlDesktop(String board) {
        return scheme + "://8chan.co/" + board + "/";
    }

    public String getThreadUrlDesktop(String board, int no) {
        return scheme + "://8chan.co/" + board + "/res/" + no;
    }

    public String getCatalogUrlDesktop(String board) {
        return scheme + "://8chan.co/" + board + "/catalog.html";
    }

    public String getPassUrl() {
        return "";
    }

    public String getReportUrl(String board, int no) {
        return "";
    }
}
