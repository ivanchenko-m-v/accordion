/*
 * Copyright 2017 mivanchenko.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.cfmc;

import com.googlecode.wicket.jquery.ui.JQueryUIBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author mivanchenko
 */
public final class PageAccordion extends WebPage
{
    private static final long serialVersionUID = 4247769885301274378L;

    public PageAccordion( PageParameters params )
    {
        super( params );
        //TODO:  process page parameters
        this.add(new JQueryUIBehavior("#accordion", "accordion"));
    }
}
