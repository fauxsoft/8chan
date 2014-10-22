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

public class HalfChanUrls implements ChanUrlsInterface {
    public static final String TAG = "4chan";

    private String scheme;

    @Override
    public String getChan(){
        return TAG;
    }

    @Override
    public void loadScheme(boolean useHttps) {
        scheme = useHttps ? "https" : "http";
    }

    @Override
    public String getCatalogUrl(String board) {
        return scheme + "://a.4cdn.org/" + board + "/catalog.json";
    }

    @Override
    public String getPageUrl(String board, int pageNumber) {
        return scheme + "://a.4cdn.org/" + board + "/" + (pageNumber + 1) + ".json";
    }

    @Override
    public String getThreadUrl(String board, int no) {
        return scheme + "://a.4cdn.org/" + board + "/thread/" + no + ".json";
    }

    @Override
    public String getCaptchaChallengeUrl() {
        return scheme + "://www.google.com/recaptcha/api/challenge?k=6Ldp2bsSAAAAAAJ5uyx_lx34lJeEpTLVkP5k04qc";
    }

    @Override
    public String getCaptchaImageUrl(String challenge) {
        return scheme + "://www.google.com/recaptcha/api/image?c=" + challenge;
    }

    @Override
    public String getImageUrl(String board, String code, String extension) {
        return scheme + "://i.4cdn.org/" + board + "/" + code + "." + extension;
    }

    @Override
    public String getThumbnailUrl(String board, String code, String extension) {
        return scheme + "://t.4cdn.org/" + board + "/" + code + "s.jpg";
    }

    @Override
    public String getSpoilerUrl() {
        return scheme + "://s.4cdn.org/image/spoiler.png";
    }

    @Override
    public String getCustomSpoilerUrl(String board, int value) {
        return scheme + "://s.4cdn.org/image/spoiler-" + board + value + ".png";
    }

    @Override
    public String getCountryFlagUrl(String countryCode) {
        return scheme + "://s.4cdn.org/image/country/" + countryCode.toLowerCase(Locale.ENGLISH) + ".gif";
    }

    @Override
    public String getTrollCountryFlagUrl(String countryCode) {
        return scheme + "://s.4cdn.org/image/country/troll/" + countryCode.toLowerCase(Locale.ENGLISH) + ".gif";
    }

    @Override
    public String getBoardsUrl() {
        return scheme + "://a.4cdn.org/boards.json";
    }

    @Override
    public String getReplyUrl(String board) {
        return "https://sys.4chan.org/" + board + "/post";
    }

    @Override
    public String getDeleteUrl(String board) {
        return "https://sys.4chan.org/" + board + "/imgboard.php";
    }

    @Override
    public String getBoardUrlDesktop(String board) {
        return scheme + "://boards.4chan.org/" + board + "/";
    }

    @Override
    public String getThreadUrlDesktop(String board, int no) {
        return scheme + "://boards.4chan.org/" + board + "/thread/" + no;
    }

    @Override
    public String getCatalogUrlDesktop(String board) {
        return scheme + "://boards.4chan.org/" + board + "/catalog";
    }

    @Override
    public String getPassUrl() {
        return "https://sys.4chan.org/auth";
    }

    @Override
    public String getReportUrl(String board, int no) {
        return "https://sys.4chan.org/" + board + "/imgboard.php?mode=report&no=" + no;
    }
}
