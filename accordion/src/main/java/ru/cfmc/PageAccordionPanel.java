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

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.widget.accordion.AccordionPanel;
import com.googlecode.wicket.jquery.ui.widget.tabs.SimpleTab;
import com.googlecode.wicket.jquery.ui.widget.tabs.TabListModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author mivanchenko
 */
public final class PageAccordionPanel extends WebPage
{
    private static final long serialVersionUID = -4604155590417966596L;

    public PageAccordionPanel( PageParameters params )
    {
        super( params );
        Form<?> frm = new Form<Void>("form");
        this.add( frm );

        //TODO:  process page parameters
		Options options = new Options();
		options.set("heightStyle", Options.asString("content"));
		options.set("collapsible", true );

        frm.add( new AccordionPanel( "accordion", this.newTabModel( ), options )
        {
            private static final long serialVersionUID = 1784212105309611696L;

            @Override
            public void onActivate( AjaxRequestTarget target, int index, ITab tab )
            {
                super.onActivate( target, index, tab );
            }

        });
    }

    private IModel<List<ITab>> newTabModel( )
	{
		return new TabListModel( )
        {
            private static final long serialVersionUID = 5275935387613157437L;

			@Override
			protected List<ITab> load()
			{
				List<ITab> tabs = new ArrayList<>( );

				// tab #1, using SimpleTab //
				tabs.add(new SimpleTab(Model.of("Simple Tab"), Model.of("my content")));

				// tab #2, invisible Tab //
				tabs.add(new SimpleTab(Model.of("Tab (random visibility)"), Model.of("now visible")) {

					private static final long serialVersionUID = 1L;

					private final boolean visible = Math.random() > 0.5; // makes the model dynamic

					@Override
					public boolean isVisible()
					{
						return this.visible;
					}
				});

                // tab #3, using SimpleTab //
				tabs.add(new SimpleTab(Model.of("Tab 3"), Model.of("tab #3, using SimpleTab")));

                // tab #4, using SimpleTab //
				tabs.add(new SimpleTab(Model.of("Tab 4"), Model.of("tab #4, using SimpleTab")));
/*
				// tab #3, using AbstractTab //
				tabs.add(new AbstractTab(Model.of("Abstract Tab")) {

					private static final long serialVersionUID = 1L;

					@Override
					public WebMarkupContainer getPanel(String panelId)
					{
						return new Fragment(panelId, "panel-1", AccordionPanelPage.this);
					}
				});

				// tab #4, using AjaxTab //
				tabs.add(new AjaxTab(Model.of("Ajax Tab")) {

					private static final long serialVersionUID = 1L;

					@Override
					public WebMarkupContainer getLazyPanel(String panelId)
					{
						try
						{
							// sleep the thread for a half second to simulate a long load
							Thread.sleep(500);
						}
						catch (InterruptedException e)
						{
							if (LOG.isDebugEnabled())
							{
								LOG.debug(e.getMessage(), e);
							}
						}

						return new Fragment(panelId, "panel-2", AccordionPanelPage.this);
					}
				});
*/
				return tabs;
			}
		};
	}
}//public final class PageAccordionPanel extends WebPage
