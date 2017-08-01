/*
 * Copyright 2017 CENTRE OF FISHERY MONITORING AND COMMUNICATIONS.
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

import com.googlecode.wicket.kendo.ui.widget.accordion.AccordionPanel;
import com.googlecode.wicket.kendo.ui.widget.tabs.SimpleTab;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

/**
 *
 * @author mivanchenko
 */
public final class PageKendoAccordionPanel extends WebPage
{
    private static final long serialVersionUID = -3673381095608806038L;

    public PageKendoAccordionPanel( PageParameters params )
    {
        super( params );
        //TODO:  process page parameters
		final Form<?> form = new Form<Void>("form");
		this.add(form);

		// Accordion //
		final AccordionPanel accordion = new AccordionPanel("accordion", this.newTabList())
        {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSelect(AjaxRequestTarget target, int index, ITab tab)
			{
                super.onSelect(target, index, tab );
			}
		};

		form.add(accordion);
    }

    private List<ITab> newTabList()
    {
		List<ITab> tabs = new ArrayList<ITab>();

		// tab #1, using SimpleTab //
		tabs.add(new SimpleTab(Model.of("Tab (SimpleTab)"), Model.of("My content !")));

		// tab #2, invisible Tab //
		tabs.add(new SimpleTab(Model.of("Tab (invisible)"), Model.of("Tab visible")));

        return tabs;
    }

}//public final class PageKendoAccordionPanel extends WebPage
