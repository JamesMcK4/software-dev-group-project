package com.group24.trelloclone.workspace;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.group24.trelloclone.workspace.service.WorkspaceService;
import com.group24.trelloclone.workspace.service.WorkspaceServiceImpl;
import com.group24.trelloclone.workspace.repository.WorkspaceRepository;;

@ExtendWith(MockitoExtension.class)
public class WorkspaceServiceImplTests {
	
	@Mock
	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@InjectMocks
	private WorkspaceService workspacesServiceImpl = new WorkspaceServiceImpl();

    
}
